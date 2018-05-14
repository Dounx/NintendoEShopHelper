Function Resize-Image
{
    param
    (
    [Switch]$Percent,
    [float]$Percentage,
    [Switch]$Pixels,
    [int]$Width,
    [int]$Height
    )
 
    begin
    {
        if( $Percent -and $Pixels)
        {
            Write-Error "���հٷֱ�(Percent)���߷ֱ���(Pixels)���ţ�ֻ����ѡ��һ�£�"
            break
        }
        elseif($Percent)
        {
            if($Percentage -le 0)
            {
              Write-Error "����Percentage��ֵ�������0��"
              break
            }
        }
        elseif($Pixels)
        {
            if( ($Width -lt 1) -or ($Height -lt 1))
            {
              Write-Error "����Width��Height��ֵ������ڵ���1��"
              break
            }
        }
        else
        {
            Write-Error "��ѡ���հٷֱ�(-Percent)���߷ֱ���(-Pixels)���ţ�"
            break
        }
        Add-Type -AssemblyName 'System.Windows.Forms'
        $count=0
 
    }
    process
    {
        $items = Get-ChildItem -Filter "*.jpg" | Select FullName
        foreach ($item in $items)
        {
            $img=[System.Drawing.Image]::FromFile($item.FullName)
 
            # ���ٷֱ����¼���ͼƬ��С
            if( ($Percentage -gt 0) -and ($Percentage -ne 1.0) )
            {
                $Width = $img.Width * $Percentage
                $Height = $img.Height * $Percentage
            }
 
            # ����ͼƬ
            $size = New-Object System.Drawing.Size($Width,$Height)
            $bitmap =  New-Object System.Drawing.Bitmap($img,$size)
 
            # ����ͼƬ
            $img.Dispose()
            $bitmap.Save($item.FullName)
            $bitmap.Dispose()
 
            $count++
        }
    }
    end
    {
        "��ϣ������� $count �˸��ļ�"
    }
}