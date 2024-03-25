package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun update() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
        // заполняем несколькими постами
        service.add(
            Post(
                1,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        service.add(
            Post(
                2,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        service.add(
            Post(
                3,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            1,
            1,
            1,
            2,
            1234,
            "Text1",
            3,
            4,
            1,
            "Ist",
            "post",
            13,
            1,
            true,
            1,
            1,
            true,
            false,
            14,
            comment,
            Likes()
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertTrue(result)
    }

    @Test
    fun update1() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
        // заполняем несколькими постами
        service.add(
            Post(
                5,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        service.add(
            Post(
                6,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        service.add(
            Post(
                7,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        // создаём информацию об обновлении
        val update = Post(
            4,
            1,
            1,
            2,
            1234,
            "Text1",
            3,
            4,
            1,
            "Ist",
            "post",
            13,
            1,
            true,
            1,
            1,
            true,
            false,
            14,
            comment,
            Likes()
        )

        // выполняем целевое действие
        val result = service.update(update)

        // проверяем результат (используйте assertTrue или assertFalse)
        assertFalse(result)
    }

    @Test
    fun add() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
        // заполняем несколькими постами
        val result = service.add(
            Post(
                7,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        ).id

        assertEquals(1, result)
    }

    @Test
    fun createComment1() {
        // создаём целевой сервис
        val service = ru.netology.WallService
        var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
        // заполняем несколькими постами
        service.add(
            Post(
                1,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )

        val result = if (service.createComment(1, comment) == comment) true else false
        assertTrue(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        // здесь код с вызовом функции, которая должна выкинуть PostNotFoundException
        // создаём целевой сервис
        val service = ru.netology.WallService
        var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
        // заполняем несколькими постами
        service.add(
            Post(
                1,
                1,
                1,
                2,
                1234,
                "Text",
                3,
                4,
                1,
                "Ist",
                "post",
                13,
                1,
                true,
                1,
                1,
                true,
                false,
                14,
                comment,
                Likes()
            )
        )
        service.createComment(1, comment)
    }
}