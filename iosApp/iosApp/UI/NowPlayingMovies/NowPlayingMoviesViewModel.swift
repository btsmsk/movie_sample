//
//  NowPlayingMoviesViewModel.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import shared
import Foundation

class NowPlayingMoviesViewModel: ObservableObject {
    private let sharedViewModel = MovieModule().movieSharedViewModel
    
    @Published var state = MovieViewState.companion.empty

    init(){
        initState()
    }
    
    func initState(){
        sharedViewModel.fetchMovie(viewState: state, type: Int32(1)).collectCommon(callback: { newState in
            self.state = newState!
        })
    }
}
