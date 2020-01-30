package cikal.dicoding.submission1.helper

import cikal.dicoding.submission1.R
import cikal.dicoding.submission1.data.MovieEntity
import cikal.dicoding.submission1.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                "m1",
                "A Star Is Born",
                R.drawable.poster_a_start_is_born,
                "2018",
                "Seasoned musician Jackson Maine discovers and falls in love with struggling artist Ally. She has just about given up on her dream to make it big as a singer until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            )
        )

        movies.add(
            MovieEntity(
                "m2",
                "Alita: Battle Angel",
                R.drawable.poster_alita,
                "2019",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            )
        )

        movies.add(
            MovieEntity(
                "m3",
                "Aquaman",
                R.drawable.poster_aquaman,
                "2018",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne."
            )
        )

        movies.add(
            MovieEntity(
                "m4",
                "Bohemian Rhapsody",
                R.drawable.poster_bohemian,
                "2018",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
        )

        movies.add(
            MovieEntity(
                "m5",
                "Creed II",
                R.drawable.poster_creed,
                "2018",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
            )
        )

        movies.add(
            MovieEntity(
                "m6",
                "Glass",
                R.drawable.poster_glass,
                "2019",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            )
        )

        movies.add(
            MovieEntity(
                "m7",
                "How to Train Your Dragon: The Hidden World",
                R.drawable.poster_how_to_train,
                "2019",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind."
            )
        )

        movies.add(
            MovieEntity(
                "m8",
                "Avengers: Infinity War",
                R.drawable.poster_infinity_war,
                "2018",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )

        movies.add(
            MovieEntity(
                "m9",
                "Mortal Engines",
                R.drawable.poster_mortal_engines,
                "2018",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
            )
        )

        movies.add(
            MovieEntity(
                "m10",
                "Ralph Breaks the Internet",
                R.drawable.poster_ralph,
                "2018",
                "Video game bad guy Ralph and fellow misfit Vanellope von Schweetz must risk it all by traveling to the World Wide Web in search of a replacement part to save Vanellope's video game, \"Sugar Rush.\" In way over their heads, Ralph and Vanellope rely on the citizens of the internet the netizens to help navigate their way, including an entrepreneur named Yesss, who is the head algorithm and the heart and soul of trend-making site BuzzzTube."
            )
        )

        return movies
    }

    fun generateDummyTvShows(): List<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                "tv1",
                "Arrow",
                R.drawable.poster_arrow,
                "2012",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv2",
                "Doom Patrol",
                R.drawable.poster_doom_patrol,
                "2019",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv3",
                "Family Guy",
                R.drawable.poster_family_guy,
                "1999",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv4",
                "The Flash",
                R.drawable.poster_flash,
                "2014",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion, and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv5",
                "Gotham",
                R.drawable.poster_gotham,
                "2014",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them, the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?"
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv6",
                "Marvel's Iron Fist",
                R.drawable.poster_iron_fist,
                "2017",
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv7",
                "Supergirl",
                R.drawable.poster_supergirl,
                "2015",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv8",
                "Supernatural",
                R.drawable.poster_supernatural,
                "2005",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv9",
                "The Simpson",
                R.drawable.poster_the_simpson,
                "1989",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general."
            )
        )

        tvShows.add(
            TvShowEntity(
                "tv10",
                "The Walking Dead",
                R.drawable.poster_the_walking_dead,
                "2010",
                "Sheriff's deputy Rick Grimes awakens from a coma to find a post-apocalyptic world dominated by flesh-eating zombies. He sets out to find his family and encounters many other survivors along the way."
            )
        )

        return tvShows
    }
}