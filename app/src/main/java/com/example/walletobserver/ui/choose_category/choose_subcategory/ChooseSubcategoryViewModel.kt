package com.example.walletobserver.ui.choose_category.choose_subcategory

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walletobserver.db.entities.SubCategoryEntity
import com.example.walletobserver.repository.SubCategoryRepository
import kotlinx.coroutines.launch

class ChooseSubcategoryViewModel(
  private val repo: SubCategoryRepository
) : ViewModel() {

  var currentCategoryID: String = ""

  private var subCategories: LiveData<List<SubCategoryEntity>> =
    repo.getSubCategoriesByCategoryId(currentCategoryID)

  fun getSubCategoriesByCategoryId(id: String): LiveData<List<SubCategoryEntity>> =
    subCategories

  fun loadSubcategories(id: String) {
    viewModelScope.launch {
      subCategories = repo.getSubCategoriesByCategoryId(id)
    }
  }
}