package com.amity.testapplication.domain.userCase

import com.amity.testapplication.data.local.db.AppDataBase
import com.amity.testapplication.domain.MainRepository
import javax.inject.Inject

class ToDoRepository @Inject constructor(
    private val appDataBase: AppDataBase,
    private val repository: MainRepository
) {
}