package com.gallapillo.shoppingcart

import android.app.Application
import com.gallapillo.shoppingcart.data.local.ItemDatabase
import com.gallapillo.shoppingcart.repository.ItemRepository
import com.gallapillo.shoppingcart.viewmodel.ItemViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ShopApplication: Application(), KodeinAware {

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule((this@ShopApplication)))
        bind() from singleton { ItemDatabase(instance()) }
        bind() from singleton { ItemRepository(instance()) }
        bind() from provider {
            ItemViewModelFactory(instance())
        }
    }
}