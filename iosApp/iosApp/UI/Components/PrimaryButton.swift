//
//  PrimaryButton.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//


import SwiftUI

struct PrimaryButton: View {
    var text: String
    var onClick: ()->Void
    
    var body: some View {
        Button(text, action: onClick)
            .padding(12)
            .foregroundColor(.white)
            .background(Color.blue)
            .cornerRadius(10)
    }
}

struct PrimaryButton_Previews: PreviewProvider {
    static var previews: some View {
        PrimaryButton(text: "Test", onClick: {})
    }
}
