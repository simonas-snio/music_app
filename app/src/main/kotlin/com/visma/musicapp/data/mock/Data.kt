package com.visma.musicapp.data.mock

import com.visma.musicapp.data.models.Category
import com.visma.musicapp.data.models.Song

val jazzCategory = Category(
    name = "Jazz",
    id = 1,
    songs = listOf(
        Song(1, "Some ultra long,very fine and beautiful title title title title", 180, 10),
        Song(2, "Jazzy Groove", 200, 12),
        Song(3, "Saxophone Serenade", 150, 8),
        Song(5, "Cool Vibes", 170, 9),
        Song(6, "Midnight Blues", 190, 11),
        Song(7, "Swinging Rhythms", 160, 7),
        Song(8, "Piano Harmony", 210, 14),
        Song(9, "Classic Jazz", 220, 15),
        Song(10, "Latin Jazz Fusion", 240, 18),
        Song(11, "Upbeat Jazz Jam", 200, 12),

    )
)

val rockCategory = Category(
    name = "Rock",
    id = 2,
    songs = listOf(
        Song(12, "Rock Anthem 1", 240, 16),
        Song(13, "Classic Rock Revival", 220, 15),
        Song(14, "Alternative Beats", 200, 12),
        Song(15, "Epic Rock Journey", 280, 22),
        Song(16, "Guitar Solo Spectacle", 190, 11),
        Song(17, "Rock Ballad", 260, 18),
        Song(18, "Hard Rock Power", 210, 14),
        Song(19, "Rock Fusion Jam", 230, 17),
        Song(20, "Heavy Metal Thunder", 270, 20),
        Song(21, "Upbeat Rock Groove", 200, 13),

        )
)

val popCategory = Category(
    name = "Pop",
    id = 3,
    songs = listOf(
        Song(22, "Pop Extravaganza 1", 210, 13),
        Song(23, "Indie Pop Vibes", 180, 10),
        Song(24, "Power Ballad", 260, 20),
        Song(25, "Pop Rock Fusion", 230, 17),
        Song(26, "Dance Pop Celebration", 250, 19),
        Song(27, "Feel-Good Pop Melody", 200, 14),
        Song(28, "Upbeat Pop Groove", 210, 14),
        Song(29, "Pop R&B Mix", 240, 16),
        Song(30, "Acoustic Pop Serenade", 190, 12),
        Song(31, "Chill Pop Vibes,", 220, 15)
    )
)

val bluesCategory = Category(
    name = "Blues",
    id = 4,
    songs = listOf(
        Song(32, "Bluesy Jam Session", 240, 15),
        Song(33, "Soulful Blues Ballad", 210, 12),
        Song(34, "Delta Blues Experience", 270, 18),
        Song(35, "Electric Blues Groove", 230, 14),
        Song(36, "Smooth Blues Fusion", 200, 13),
        Song(37, "Jazzy Blues Journey", 250, 16),
        Song(38, "Upbeat Blues Rhythm", 220, 15),
        Song(39, "Acoustic Blues Melody", 190, 12),
        Song(40, "Blues Rock Revival", 260, 17),
        Song(41, "Chilled Blues Serenade", 210, 14)
    )
)


val data = listOf(jazzCategory, rockCategory, popCategory, bluesCategory)