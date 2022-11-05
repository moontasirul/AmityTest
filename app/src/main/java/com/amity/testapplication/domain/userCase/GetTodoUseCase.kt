package com.amity.testapplication.domain.userCase

import com.amity.testapplication.domain.IMainRepository
import javax.inject.Inject

class GetTodoUseCase @Inject constructor(
    private val mainRepository: IMainRepository
) {
    suspend operator fun invoke() = mainRepository.getAllData()
}