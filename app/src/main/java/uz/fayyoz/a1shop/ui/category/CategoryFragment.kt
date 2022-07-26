package uz.fayyoz.a1shop.ui.category

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.fayyoz.a1shop.R
import uz.fayyoz.a1shop.databinding.CategoryFragmentBinding
import uz.fayyoz.a1shop.ui.BaseFragment
import uz.fayyoz.a1shop.di.RetrofitService
import uz.fayyoz.a1shop.repository.ProductRepoImpl
import uz.fayyoz.a1shop.ui.category.adapter.ProductAdapter

class CategoryFragment() : BaseFragment<CategoryFragmentBinding>(R.layout.category_fragment) {

    override fun initViewBinding(view: View): CategoryFragmentBinding =
        CategoryFragmentBinding.bind(view)

    private val repo: ProductRepoImpl = ProductRepoImpl(RetrofitService.shopService)
    private val productsAdapter: ProductAdapter = ProductAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val position = arguments?.getInt(POSITION_ARG)
        repo.getByCategory(position!!)

        setUpRv()
        repo.newsLiveData.observe(viewLifecycleOwner) {
            productsAdapter.submitList(it)
        }
    }

    private fun setUpRv() {
        binding.recyclerView.apply {
            layoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            adapter = productsAdapter
        }
    }

    companion object {

        var POSITION_ARG = "position_arg"

        @JvmStatic
        fun newInstance(position: Int) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putInt(POSITION_ARG, position+1)
            }
        }
    }
}