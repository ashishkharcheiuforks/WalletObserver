package com.grappim.walletobserver.ui.choose_category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.grappim.walletobserver.repository.CategoryRepository

class ChooseCategoryViewModelFactory(
  private val repo: CategoryRepository
) : ViewModelProvider.NewInstanceFactory(){
  override fun <T : ViewModel?> create(modelClass: Class<T>): T =
    ChooseCategoryViewModel(repo) as T
}