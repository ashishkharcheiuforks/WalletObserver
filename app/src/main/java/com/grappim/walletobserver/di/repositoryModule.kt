package com.grappim.walletobserver.di

import com.grappim.walletobserver.repository.CategoryRepository
import com.grappim.walletobserver.repository.RecordRepository
import com.grappim.walletobserver.repository.SubCategoryRepository
import com.grappim.walletobserver.util.*
import org.koin.core.qualifier.named
import org.koin.dsl.module

val repositoryModule = module {
  single(named(KOIN_RECORD_REPO)) { RecordRepository(get(named(KOIN_RECODR_DAO))) }
  single(named(KOIN_CATEGORY_REPO)) { CategoryRepository(get(named(KOIN_CATEGORY_DAO))) }
  single(named(KOIN_SUBCATEGORY_REPO)) { SubCategoryRepository(get(named(KOIN_SUB_CATEGORY_DAO))) }
}