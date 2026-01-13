package com.example.contactapp.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {
    @Upsert
    suspend fun upsertContact(contact: Contact)

    @Delete
    suspend fun deleteContact(contact: Contact)

    @Query ("SELECT * FROM Contact_Table ORDER by name ASC" )
    fun getContactsSortedByName(): Flow<List<Contact>>

    @Query ("SELECT * FROM Contact_Table ORDER by dateOfCreation ASC" )
    fun getContactsSortedByDateOfCreation(): Flow<List<Contact>>

    @Query ("SELECT * FROM Contact_Table ORDER by phone ASC" )
    fun getContactsSortedByPhoneNumber(): Flow<List<Contact>>



}
