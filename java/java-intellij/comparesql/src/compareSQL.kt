

val sqliteHeader = byteArrayOf(
    'S'.toByte(),
    'Q'.toByte(),
    'L'.toByte(),
    'i'.toByte(),
    't'.toByte(),
    'e'.toByte(),
    ' '.toByte(),
    'f'.toByte(),
    'o'.toByte(),
    'r'.toByte(),
    'm'.toByte(),
    'a'.toByte(),
    't'.toByte(),
    ' '.toByte(),
    '3'.toByte(),
    0
)

fun main() {
    for(byte in sqliteHeader)
        print(byte)
}