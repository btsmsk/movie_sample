//
//  UpcomingMoviesScreen.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct UpcomingMoviesScreen: View {
    @ObservedObject private var viewModel = UpcomingMoviesViewModel()
    private let refreshName = "upcomingMovies"
    
    var body: some View {
        let state = viewModel.state
        ScrollView(.vertical){
                RefreshView(coordinateSpaceName: refreshName){viewModel.initState()}
                if(state.error != nil){
                    ErrorScreen(message: state.error!.message!){viewModel.initState()}
                }
                if(state.movieResponse != nil){
                    MovieContentScreen(movieList: state.movieResponse!.movieDataList).padding(.top,8)
                }
            }.coordinateSpace(name: refreshName)
            .onAppear(perform: {
                UIScrollView.appearance().backgroundColor = UIColor(.white)
            })
    }
}

struct UpcomingMoviesScreen_Previews: PreviewProvider {
    static var previews: some View {
        UpcomingMoviesScreen()
    }
}
