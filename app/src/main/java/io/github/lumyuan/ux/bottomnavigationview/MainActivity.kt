package io.github.lumyuan.ux.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import io.github.lumyuan.ux.bottomnavigationview.databinding.ActivityMainBinding
import io.github.lumyuan.ux.bottomnavigationview.widget.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigationView.apply {
            //创建Item，推荐最少3个，最多5个
            val homeItem = newItemView().apply {
                this.setImageResource(R.drawable.ic_home)
                this.setText(R.string.home)
            }
            val moduleItem = newItemView().apply {
                this.setImageResource(R.drawable.ic_module)
                this.setText(R.string.module)
            }
            val mineItem = newItemView().apply {
                this.setImageResource(R.drawable.ic_mine)
                this.setText(R.string.mine)
            }
            //给导航栏添加Item
            addItemView(homeItem)
            addItemView(moduleItem)
            addItemView(mineItem)

            //设置选择监听器
            setOnItemSelectListener { position, view ->
                val item = view as NavigationView.Item
                binding.title.text = item.titleView.text
            }
        }

    }
}