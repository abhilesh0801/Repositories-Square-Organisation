package com.poqtest.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poqtest.data.repository.RepoRepository
import com.poqtest.data.model.Repo
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RepoListViewModel @Inject constructor(private val repoRepository: RepoRepository): ViewModel() {

    var loaderVisibility: MutableLiveData<Int> = MutableLiveData()
    val repoListAdapter: RepoListAdapter = RepoListAdapter()

    init {
        loadRepositories()
    }

    private fun loadRepositories() {
        loaderVisibility.value = View.VISIBLE
        repoRepository.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableObserver<List<Repo>>() {
                override fun onComplete() {
                }

                override fun onNext(repositories: List<Repo>) {
                    repoListAdapter.updateRepoList(repositories)
                    loaderVisibility.value = View.GONE
                }

                override fun onError(e: Throwable) {
                    loaderVisibility.value = View.GONE
                }
            })
    }
}