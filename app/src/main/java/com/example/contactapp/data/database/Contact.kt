package com.example.contactapp.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contact_Table")
data class Contact (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    var name : String,
    var phone : String,
    var email : String,
    var isActive: Boolean,
    var dateOfCreation : Long,
    var image : ByteArray? = null
    )
