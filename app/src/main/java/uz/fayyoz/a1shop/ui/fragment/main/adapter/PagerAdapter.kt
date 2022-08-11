package uz.fayyoz.a1shop.ui.fragment.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import uz.fayyoz.a1shop.ui.fragment.category.CategoryFragment

class PagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 5

    override fun createFragment(position: Int) =
        CategoryFragment.newInstance(position)

}
