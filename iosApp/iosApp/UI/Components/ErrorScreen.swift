//
//  ErrorView.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct ErrorScreen: View {
    var message: String
    var onRetry: ()->Void
    
    var body: some View {
        VStack{
            Text(message)
            PrimaryButton(text: "Retry", onClick: onRetry)
        }
    }
}

struct ErrorScreen_Previews: PreviewProvider {
    static var previews: some View {
        ErrorScreen(message: "Test", onRetry: {})
    }
}

