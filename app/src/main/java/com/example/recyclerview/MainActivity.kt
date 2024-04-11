package com.example.recyclerview


import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b : ActivityMainBinding
    lateinit var recView : RecyclerView
    lateinit var newsArray : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        recView = b.reV
        val imgArray = arrayOf(R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
            R.drawable.img6,R.drawable.img7,R.drawable.img8)
        val newsHead = arrayOf("'BJP approached me to join party or face jail': AAP leader Atishi",
            "Sunita Kejriwal Reads Out Jailed Husband's Statement",
            "Court rejects plea seeking removal of jailed Arvind Kejriwal as Chief Minister",
            "PM Modi sets ambitious India economic goals for probable third term",
            "Thousands show up at INDIA bloc rally in Delhi",
            "Earthquake today: A magnitude 5.3 quake hit Himachal Pradesh's Chamba",
            "IIT Bombay reacts to ‘36% graduates without placement’",
            "motorola edge 50 Pro launched in India starting at Rs. 31999")


        val newsContent = arrayOf(getString(R.string.news_4),getString(R.string.news_5),getString(R.string.news_6),
            getString(R.string.news_7),getString(R.string.news),getString(R.string.news_3),
            getString(R.string.news_2),getString(R.string.news_1))
        //layout manager is responsible for measuring and positioning of item views and manages vertical/horizontal scroll
        recView.layoutManager = LinearLayoutManager(this)
        newsArray = ArrayList()

        for(i in imgArray.indices){
            val obj = News(newsHead[i],imgArray[i],newsContent[i])
            newsArray.add(obj)
        }
        val myAdapter = MyAdapter(newsArray,this)
        recView.adapter = myAdapter
        myAdapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                //on clicking each item, what action do you want to perform

                val intent = Intent(applicationContext,MainActivity2::class.java)
                intent.putExtra("head",newsArray[position].head)
                intent.putExtra("body",newsArray[position].newsContent)
                intent.putExtra("image",newsArray[position].image)
                startActivity(intent)
            }

        })

        }
    }
