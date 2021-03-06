package com.grappim.walletobserver.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(
  tableName = "sub_ctgry_table",
  foreignKeys = [
    ForeignKey(
      entity = CategoryEntity::class,
      parentColumns = ["category_id"],
      childColumns = ["category_id"],
      onDelete = ForeignKey.CASCADE,
      onUpdate = ForeignKey.CASCADE
    )]
)
data class SubCategoryEntity(
  @PrimaryKey
  @ColumnInfo(name = "sub_ctgry_id")
  val id: String = UUID.randomUUID().toString(),
  @ColumnInfo(name = "sub_ctgry_name")
  val name: String?,
  @ColumnInfo(name = "sub_ctgry_icon")
  val icon: String? = "",
  @ColumnInfo(name = "category_id")
  var categoryId: String = ""
) {

  companion object {
    fun dummyObject() = SubCategoryEntity(
      name = "",
      icon = "",
      categoryId = ""
    )
  }
}