//
//  MovieItem.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct MovieItem: View {
    var movie: Movie
    @StateObject private var loader: ImageLoader
    
    init(movie: Movie){
        self.movie = movie
        _loader = StateObject(wrappedValue: ImageLoader(url: movie.poster.asUrl(), cache: Environment(\.imageCache).wrappedValue))
    }
    
    var body: some View {
        
        ZStack{
            RoundedRectangle(cornerRadius: 8, style: .continuous).fill(Color.white).shadow(radius: 3)
            VStack(alignment: .leading, spacing: nil, content: {
                HStack{
                    
                    if loader.image != nil {
                        Image(uiImage: loader.image!).resizable().clipped()
                            .aspectRatio(contentMode: .fit)
                            .frame(height: 130)
                            .clipShape(RoundedCornersShape(corners: [.topLeft, .bottomLeft], radius: 8))
                    } else {
                        Image("default_image").resizable().clipped()
                            .aspectRatio(contentMode: .fit)
                            .frame(height: 130)
                            .clipShape(RoundedCornersShape(corners: [.topLeft, .bottomLeft], radius: 8))
                    }
                    
                    VStack{
                        HStack{Text(movie.originalTitle).font(.body).bold()
                            Spacer()
                        }
                        HStack{
                            Text("Release Date: \(movie.releaseDate)").font(.body).padding(.top, 12)
                            Spacer()
                        }
                    }.frame(height: 130)
                }
            })
        } .onAppear(perform: {loader.load()})
        ///zstack
        .padding(.horizontal)
    }
}

struct MovieItem_Previews: PreviewProvider {
    static var previews: some View {
        MovieItem(movie: Movie.companion.mocked)
    }
}

