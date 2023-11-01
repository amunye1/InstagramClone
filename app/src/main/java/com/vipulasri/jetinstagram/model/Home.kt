package com.vipulasri.jetinstagram.model

data class Post(
  val id: Int,
  val image: String,
  val user: User,
  val isLiked: Boolean = false,
  val likesCount: Int,
  val commentsCount: Int,
  val timeStamp: Long
)

data class Story(
  val image: String,
  val name: String,
  val isSeen: Boolean = false,

)

val names = arrayOf(
    "storee",
    "nianyc",
    "opioke",
    "ashoke",
    "dark_emarlds",
    "bedtan",
    "shrish",
    "matdo",
    "phillsohn",
    "deitch"
)

val fullnames = arrayOf(
    "Storee Whitfield",
    "Nianyc Castellanos",
    "Opioke Harrington",
    "Ashoke Vanderbilt",
    "Dark Emarlds Nightingale",
    "Bedtan Moreau",
    "Shrish Endicott",
    "Matdo Beaumont",
    "Phillsohn Cartwright",
    "Deitch Everwood"
)