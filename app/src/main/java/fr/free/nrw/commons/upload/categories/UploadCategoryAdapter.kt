package fr.free.nrw.commons.upload.categories

import fr.free.nrw.commons.category.CategoryItem
import java.util.ArrayList

class UploadCategoryAdapter(
    onCategoryClicked: (CategoryItem) -> Unit,
    existingCategories: ArrayList<String>
) :
    BaseDelegateAdapter<CategoryItem>(
        uploadCategoryDelegate(onCategoryClicked, existingCategories),
        areItemsTheSame = { oldItem, newItem -> oldItem.name == newItem.name },
        areContentsTheSame = { oldItem, newItem ->
            oldItem.name == newItem.name && oldItem.isSelected == newItem.isSelected
        }
    )


