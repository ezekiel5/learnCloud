Get-ChildItem -Recurse -Filter *.java -File | ForEach-Object {
    try {
        "===== $($_.FullName) ====="
        Get-Content -Path $_.FullName -ErrorAction Stop
    } catch {
        "ERROR reading file: $($_.FullName)"
    }
} | Out-File all_java_code.txt -Encoding utf8