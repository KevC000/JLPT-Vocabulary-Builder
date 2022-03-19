package com.example.jlptvocabularybuilder

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Word(

    //var id: Long ?=null,

    val furigana: String,

    val level: Int,

    val meaning: String,

    val romaji: String,

    val uuid: String,

    val word: String,

    //val correct:Int=0,

    //val incorrect:Int=0,

    //val total:Int=correct+incorrect,

    //val percentage:Int=correct/total*100


)

