package ru.netology

import ru.netology.WallService.add

class Likes
class Donut
class Thread
class PostNotFoundException : Exception()

data class Post(
    var id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?, // Nullable
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Int,
    val copyright: String,
    val postType: String,
    val signerId: Int,
    val canPin: Int,
    val canDelete: Boolean,
    val canEdit: Int,
    val isPinned: Int,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val postponedId: Int,
    var comments: Comment?, // Nullable
    var likes: Likes?, // Nullable
    val attachments: Array<Attachment> = emptyArray()
)

class Comment(
    val id: Int,
    val fromId: Int,
    val date: Int,
    val text: String,
    var donut: Donut,
    val replyToUser: Int,
    val replyToComment: Int,
    var thread: Thread,
    val attachments: Array<Attachment> = emptyArray()
)

object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var recordId: Int = 0

    fun clear() {
        posts = emptyArray()
        recordId = 0 // сброс счетчика для id постов
    }

    // добавление возможности комментирования
    //Функция сначала должна проверить, существует ли в массиве posts пост с ID равным postId. Если существует, то добавить комментарий в массив comments и вернуть только что добавленный комментарий.
    // Если не существует, выкинуть исключение PostNotFoundException.
    fun createComment(postId: Int, comment: Comment): Comment? {
        try {
            for (post in posts) {
                if (post.id == postId) {
                    comments += comment
                }
                return comment
            }
        } catch (e: PostNotFoundException) {
            println("PostNotFoundException")
        }
        return null
    }

    fun add(post: Post): Post {
        recordId++
        post.id = recordId
        posts += post
        return posts.last()
    }

    fun update(postNew: Post): Boolean {
        var flag: Boolean = false
        for (post in posts) {
            if (postNew.id == post.id) {
                var post = postNew
                flag = true
            }
        }
        return flag
    }
}


class Photo(
    val id: Int,
    val album_id: Int,
    val owner_id: Int,
    val user_id: Int,
    val text: String
)

class Audio(
    val id: Int,
    val owner_id: Int,
    val artist: String,
    val title: String,
    val duration: Int
)

class Video(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val description: String,
    val duration: Int
)

class File(
    val id: Int,
    val owner_id: Int,
    val title: String,
    val size: Int,
    val ext: String
)

class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    var photo: Photo
)

interface Attachment {
    val type: String
}

class PhotoAttachment(
    override val type: String,
    var photo: Photo
) : Attachment {
}

class AudioAttachment(
    override val type: String,
    var audio: Audio
) : Attachment {
}

class VideoAttachment(
    override val type: String,
    var video: Video
) : Attachment {
}

class FileAttachment(
    override val type: String,
    var file: File
) : Attachment {
}

class LinkAttachment(
    override val type: String,
    var link: Link
) : Attachment {
}

fun main() {
    var comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
    var post =
        Post(1, 1, 1, 2, 1234, "Text", 3, 4, 1, "Ist", "post", 13, 1, true, 1, 1, true, false, 14, comment, Likes())
    println(add(post))
    WallService.createComment(1, comment)
    WallService.createComment(2, comment)


    comment = Comment(1, 2, 3, "Com", Donut(), 1, 1, Thread());
    post =
        Post(1, 2, 1, 2, 1234, "Text", 3, 4, 1, "Ist", "post", 13, 1, true, 1, 1, true, false, 14, comment, Likes())
    println(add(post))
}

