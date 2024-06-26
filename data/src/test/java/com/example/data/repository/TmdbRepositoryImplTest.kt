package com.example.data.repository

import com.example.common.Constants
import com.example.data.remote.TmdbApi
import com.example.domain.model.Dates
import com.example.domain.model.MovieResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class TmdbRepositoryImplTest {

    private lateinit var repository: TmdbRepositoryImpl
    private val api: TmdbApi = mockk()

    @Before
    fun setUp() {
        repository = TmdbRepositoryImpl(api)
    }

    @Test
    fun `getMovieNowPlaying returns movie response`() = runBlockingTest {
        // Arrange
        val movieResponse = MovieResponse(
            dates = Dates("2024-06-26", "2024-05-15"),
            page = 1,
            results = listOf(
                com.example.domain.model.Result(
                    "/stKGOm8UyhuLPR9sZLjs5AkmncA.jpg",
                    1022789,
                    "Teenager Riley's mind headquarters is undergoing a sudden demolition to make room for something entirely unexpected: new Emotions! Joy, Sadness, Anger, Fear and Disgust, who’ve long been running a successful operation by all accounts, aren’t sure how to feel when Anxiety shows up. And it looks like she’s not alone.",
                    "/oxxqiyWrnM0XPnBtVe9TgYWnPxT.jpg",
                    "2024-06-11",
                    "Inside Out 2"
                ),
                com.example.domain.model.Result(
                    "/fqv8v6AycXKsivp1T5yKtLbGXce.jpg",
                    653346,
                    "Several generations in the future following Caesar's reign, apes are now the dominant species and live harmoniously while humans have been reduced to living in the shadows. As a new tyrannical ape leader builds his empire, one young ape undertakes a harrowing journey that will cause him to question all that he has known about the past and to make choices that will define a future for apes and humans alike.",
                    "/gKkl37BQuKTanygYQG1pyYgLVgf.jpg",
                    "2024-05-08",
                    "Kingdom of the Planet of the Apes"
                ),
                com.example.domain.model.Result(
                    "/gRApXuxWmO2forYTuTmcz5RaNUV.jpg",
                    573435,
                    "After their late former Captain is framed, Lowrey and Burnett try to clear his name, only to end up on the run themselves.",
                    "/nP6RliHjxsz4irTKsxe8FRhKZYl.jpg",
                    "2024-06-05",
                    "Bad Boys: Ride or Die"
                ),
                com.example.domain.model.Result(
                    "/nxxCPRGTzxUH8SFMrIsvMmdxHti.jpg",
                    639720,
                    "A young girl who goes through a difficult experience begins to see everyone's imaginary friends who have been left behind as their real-life friends have grown up.",
                    "/xbKFv4KF3sVYuWKllLlwWDmuZP7.jpg",
                    "2024-05-08",
                    "IF"
                ),
                com.example.domain.model.Result(
                    "/iTWrsOVsUqcwYSxrpINNs3hG2nC.jpg",
                    1001311,
                    "In the Summer of 2024, Paris is hosting the World Triathlon Championships on the Seine for the first time. Sophia, a brilliant scientist, learns from Mika, a young environmental activist, that a large shark is swimming deep in the river. To avoid a bloodbath at the heart of the city, they have no choice but to join forces with Adil, the Seine river police commander.",
                    "/flX5OSC1NAKHqjLIZL5YcyxtSXh.jpg",
                    "2024-06-05",
                    "Under Paris"
                ),
                com.example.domain.model.Result(
                    "/z121dSTR7PY9KxKuvwiIFSYW8cf.jpg",
                    929590,
                    "In the near future, a group of war journalists attempt to survive while reporting the truth as the United States stands on the brink of civil war.",
                    "/sh7Rg8Er3tFcN9BpKIPOMvALgZd.jpg",
                    "2024-04-10",
                    "Civil War"
                ),
                com.example.domain.model.Result(
                    "/oZDRuGHhe5uY8wBqFJcJZT9kdvJ.jpg",
                    1086747,
                    "A young artist gets stranded in an extensive, immaculate forest in western Ireland, where, after finding shelter, she becomes trapped alongside three strangers, stalked by mysterious creatures each night.",
                    "/vZVEUPychdvZLrTNwWErr9xZFmu.jpg",
                    "2024-06-06",
                    "The Watchers"
                ),
                com.example.domain.model.Result(
                    "/SI22DaQXIfDvLrNBHGpSVShrsC.jpg",
                    829402,
                    "With Tokyo under attack from kaiju, Ultraman discovers his greatest challenge isn’t fighting giant monsters - it’s raising one.",
                    "/j886YEkIUsiImY53px5VHKD4lRa.jpg",
                    "2024-06-14",
                    "Ultraman: Rising"
                ),

                com.example.domain.model.Result(
                    "/3TNSoa0UHGEzEz5ndXGjJVKo8RJ.jpg",
                    614933,
                    "A brilliant counterterrorism analyst with a deep distrust of AI discovers it might be her only hope when a mission to capture a renegade robot goes awry.",
                    "/bcM2Tl5HlsvPBnL8DKP9Ie6vU4r.jpg",
                    "2024-05-23",
                    "Atlas"
                ),
                com.example.domain.model.Result(
                    "/oavbmL3iddJUmC8nQjL6bLHwAP4.jpg",
                    719221,
                    "When a group of friends recklessly violate the sacred rule of Tarot readings, they unknowingly unleash an unspeakable evil trapped within the cursed cards. One by one, they come face to face with fate and end up in a race against death.",
                    "/gAEUXC37vl1SnM7PXsHTF23I2vq.jpg",
                    "2024-05-01",
                    "Tarot"
                ),
                com.example.domain.model.Result(
                    "/H5HjE7Xb9N09rbWn1zBfxgI8uz.jpg",
                    746036,
                    "Fresh off an almost career-ending accident, stuntman Colt Seavers has to track down a missing movie star, solve a conspiracy and try to win back the love of his life while still doing his day job.",
                    "/aBkqu7EddWK7qmY4grL4I6edx2h.jpg",
                    "2024-04-24",
                    "The Fall Guy"
                ),
                com.example.domain.model.Result(
                    "/fDmci71SMkfZM8RnCuXJVDPaSdE.jpg",
                    519182,
                    "Gru and Lucy and their girls — Margo, Edith and Agnes — welcome a new member to the Gru family, Gru Jr., who is intent on tormenting his dad. Gru faces a new nemesis in Maxime Le Mal and his femme fatale girlfriend Valentina, and the family is forced to go on the run.",
                    "/wWba3TaojhK7NdycRhoQpsG0FaH.jpg",
                    "2024-06-20",
                    "Despicable Me 4"
                ),

                com.example.domain.model.Result(
                    "/raph7qjAGTMXaIjVxt6ZDSXRzUr.jpg",
                    786892,
                    "As the world fell, young Furiosa is snatched from the Green Place of Many Mothers and falls into the hands of a great Biker Horde led by the Warlord Dementus. Sweeping through the Wasteland they come across the Citadel presided over by The Immortan Joe. While the two Tyrants war for dominance, Furiosa must survive many trials as she puts together the means to find her way home.",
                    "/iADOJ8Zymht2JPMoy3R7xceZprc.jpg",
                    "2024-05-22",
                    "Furiosa: A Mad Max Saga"
                ),
                com.example.domain.model.Result(
                    "/vWzJDjLPmycnQ42IppEjMpIhrhc.jpg",
                    748783,
                    "Garfield, the world-famous, Monday-hating, lasagna-loving indoor cat, is about to have a wild outdoor adventure! After an unexpected reunion with his long-lost father – scruffy street cat Vic – Garfield and his canine friend Odie are forced from their perfectly pampered life into joining Vic in a hilarious, high-stakes heist.",
                    "/tSPsiMHb4edeBKZZjKDmhX18Jbs.jpg",
                    "2024-04-30",
                    "The Garfield Movie"
                ),
                com.example.domain.model.Result(
                    "/zs2S0D4sZMNbOKgs4LyZAxiX9eY.jpg",
                    1197830,
                    "Lily Pierce is sick of being haunted. She decides to reconnect with her estranged father, a disgraced history professor, and learn how to draw upon a time of steel and blade when armor-clad knights rode out and dueled their monsters to the death.",
                    "/nJMNvYZ21bMdB2Pq0qCk88jnQc6.jpg",
                    "2024-06-11",
                    "Wild Eyed and Wicked"
                ),
                com.example.domain.model.Result(
                    "/5Eip60UDiPLASyKjmHPMruggTc4.jpg",
                    1041613,
                    "An American nun embarks on a new journey when she joins a remote convent in the Italian countryside. However, her warm welcome quickly turns into a living nightmare when she discovers her new home harbours a sinister secret and unspeakable horrors.",
                    "/fdZpvODTX5wwkD0ikZNaClE4AoW.jpg",
                    "2024-03-20",
                    "Immaculate"
                ),
                com.example.domain.model.Result(
                    "/nv6F6tz7r61DUhE7zgHwLJFcTYp.jpg",
                    974635,
                    "A mild-mannered professor moonlighting as a fake hit man in police stings ignites a chain reaction of trouble when he falls for a potential client.",
                    "/1126gjlBf4hTm9Sgf0ox3LGVEBt.jpg",
                    "2024-05-16",
                    "Hit Man"
                ),
                com.example.domain.model.Result(
                    "/sNBnCmF1ueoERa4uW5kh929KkRO.jpg",
                    858017,
                    "Teenager Owen is just trying to make it through life in the suburbs when his classmate introduces him to a mysterious late-night TV show — a vision of a supernatural world beneath their own. In the pale glow of the television, Owen’s view of reality begins to crack.",
                    "/hS4GYkYpN1rfl4GIxyc02sCyfAj.jpg",
                    "2024-05-03",
                    "I Saw the TV Glow"
                ),
                com.example.domain.model.Result(
                    "/1m1rXopfNDVL3UMiv6kriYaJ3yE.jpg",
                    882059,
                    "When his family is murdered, a deaf-mute named Boy escapes to the jungle and is trained by a mysterious shaman to repress his childish imagination and become an instrument of death.",
                    "/25JskXmchcYwj3jHRmcPm738MpB.jpg",
                    "2024-04-24",
                    "Boy Kills World"
                ),
                com.example.domain.model.Result(
                    "/nb3xI8XI3w4pMVZ38VijbsyBqP4.jpg",
                    872585,
                    "The story of J. Robert Oppenheimer's role in the development of the atomic bomb during World War II.",
                    "/8Gxv8gSFCU0XGDykEGv7zR1n2ua.jpg",
                    "2023-07-19",
                    "Oppenheimer"
                )
            ),
            totalPages = 232,
            totalResults = 4640
        )
        coEvery { api.getMovieNowPlaying(Constants.key) } returns movieResponse

        // Act
        val result = repository.getMovieNowPlaying()

        // Assert
        assertEquals(movieResponse.results!!.size, result.results!!.size)
        assertEquals(movieResponse.dates!!.maximum, result.dates!!.maximum)
    }
}