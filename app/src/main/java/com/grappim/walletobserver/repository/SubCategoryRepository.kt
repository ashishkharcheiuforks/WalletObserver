package com.grappim.walletobserver.repository

import androidx.lifecycle.LiveData
import com.grappim.walletobserver.db.dao.SubCategoryDao
import com.grappim.walletobserver.db.entities.SubCategoryEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SubCategoryRepository(
  private val subCategoryDao: SubCategoryDao
) {

  private val allSubCategories: LiveData<List<SubCategoryEntity>> =
    subCategoryDao.getAllSubCategories()

  fun getAllSubCategories() = allSubCategories

  fun getSubCategoriesByCategoryId(id: String): LiveData<List<SubCategoryEntity>> =
    subCategoryDao.getSubCategoriesForCategory(id)

  suspend fun insertSubCategories(subCategories: List<SubCategoryEntity>) =
    withContext(Dispatchers.IO) {
      subCategoryDao.insertList(subCategories)
    }

  suspend fun deleteSubCategory(subCategory: SubCategoryEntity) =
    withContext(Dispatchers.IO) {
      subCategoryDao.delete(subCategory)
    }
}