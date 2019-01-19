package guide.betterfuture.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import guide.betterfuture.articlelist.presentation.view.ArticleListFragment
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    private lateinit var toolbar: ActionBar

    private lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        toolbar = supportActionBar!!
        fragment = ArticleListFragment()
        showFragment(fragment)
        navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_articles -> {
                    toolbar.title = getString(R.string.title_articles)
                    fragment = ArticleListFragment()
                    showFragment(fragment)
                    true
                }
                R.id.navigation_charities -> {
                    toolbar.title = getString(R.string.title_charities)
                    fragment = Fragment()
                    showFragment(fragment)
                    true
                }
                R.id.navigation_organizations -> {
                    toolbar.title = getString(R.string.title_organizations)
                    fragment = Fragment()
                    showFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .addToBackStack(null)
            .commit()
    }
}
