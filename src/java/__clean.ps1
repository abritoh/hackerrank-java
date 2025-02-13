$path = Get-Location
Get-ChildItem -Path $path -Recurse -Filter "*.class" | Remove-Item -Force
