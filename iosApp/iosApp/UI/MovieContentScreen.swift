//
//  MovieContentScreen.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieContentScreen: View {
    var movieList: [Movie]
    
    var body: some View {
        ForEach(movieList, id: \.movieId){movie in
                MovieItem(movie: movie)
        }
    }
}

struct MovieContentScreen_Previews: PreviewProvider {
    static var previews: some View {
        MovieContentScreen(movieList: MovieResponse.companion.mocked.movieDataList)
    }
}
