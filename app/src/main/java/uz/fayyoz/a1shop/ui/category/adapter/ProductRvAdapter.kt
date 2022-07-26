package uz.fayyoz.a1shop.ui.category.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.fayyoz.a1shop.model.Products
import uz.fayyoz.a1shop.R
import uz.fayyoz.a1shop.databinding.ItemProductBinding
import uz.fayyoz.a1shop.getDrawable
import uz.fayyoz.a1shop.inflate
import uz.fayyoz.a1shop.setImageRemote
import uz.fayyoz.a1shop.utill.ProductsComparator

class ProductAdapter : ListAdapter<Products, ProductVH>(ProductsComparator()) {

    private var onClickListener: ((Products) -> Unit)? = null

    fun onProductClickListener(listener: ((Products) -> Unit)) {
        onClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
        return ProductVH(parent.inflate(R.layout.item_product))
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {

        holder.onBind(getItem(position), onClickListener ?: {})

    }
}

class ProductVH(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemProductBinding.bind(view)
    private val errImg = getDrawable(view.context, R.drawable.error_image)

    fun onBind(
        products: Products,
        onClick: (Products) -> Unit,
    ) {
        binding.apply {
            itemImage.setImageRemote(products.images[0], errImg)
            itemTitle.text = products.title
            itemPrice.text = products.price.toInt().toString()+" $"
            productContainer.setOnClickListener {
                onClick.invoke(products)
            }
        }
    }

}
