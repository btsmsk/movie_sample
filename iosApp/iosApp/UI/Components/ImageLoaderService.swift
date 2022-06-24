//
//  ImageLoaderService.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import SwiftUI

class ImageLoaderService: ObservableObject {
    @Published var image: UIImage = UIImage()
    
    func loadImage(for urlString: String) {
        guard let url = URL(string: urlString) else { return }
        
        let task = URLSession.shared.dataTask(with: url) { data, response, error in
            guard let data = data else { return }
            DispatchQueue.main.async {
                self.image = UIImage(data: data) ?? UIImage()
            }
        }
        task.resume()
    }
    
}
