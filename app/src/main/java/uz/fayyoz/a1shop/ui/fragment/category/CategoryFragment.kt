package uz.fayyoz.a1shop.ui.fragment.category

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import uz.fayyoz.a1shop.R
import uz.fayyoz.a1shop.databinding.CategoryFragmentBinding
import uz.fayyoz.a1shop.ui.fragment.BaseFragment
import uz.fayyoz.a1shop.ui.fragment.category.adapter.ProductAdapter
import uz.fayyoz.a1shop.ui.fragment.category.vm.CategoryVM
import uz.fayyoz.a1shop.utill.ViewModelFactory

class CategoryFragment() : BaseFragment<CategoryFragmentBinding>(R.layout.category_fragment) {

    override fun initViewBinding(view: View): CategoryFragmentBinding = CategoryFragmentBinding.bind(view)
    private val productVM by viewModels<CategoryVM> { ViewModelFactory() }
    private val productsAdapter: ProductAdapter = ProductAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val position = arguments?.getInt(POSITION_ARG)
        productVM.getByCategory(position!!).observe(viewLifecycleOwner) {
            productsAdapter.submitList(it)
        }
        setUpRv()
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
                putInt(POSITION_ARG, position + 1)
            }
        }
    }
}