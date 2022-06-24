//
//  UpcomingScreenViewModel.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

import Foundation
import shared

class UpcomingMoviesViewModel: ObservableObject{
    private let sharedViewModel = MovieModule().movieSharedViewModel
    
    @Published var state = MovieViewState.companion.empty
    
    init(){
        initState()
    }
    
    func initState(){
        sharedViewModel.fetchMovie(viewState: state, type: Int32(2)).collectCommon(callback: {newState in
            self.state = newState!
        })
    }
}
