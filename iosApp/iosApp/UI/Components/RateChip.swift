//
//  RateChip.swift
//  iosApp
//
//  Created by Batuhan Simsek on 24.06.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct RateChip: View {
    var rate: String
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 8, style: .continuous).fill(Color.black)
            VStack(alignment: .leading, spacing: nil, content: {
                HStack{
                    
                    Image("ic_star").resizable().clipped()
                        .aspectRatio(contentMode: .fit)
                        .frame(width: 16, height: 16)
                    
                    
                    Text(rate).font(.caption2).frame(alignment: Alignment.leading).foregroundColor(Color.white)
                }
            })
        }.frame(width: 50, height: 24)
    }
}

struct RateChip_Previews: PreviewProvider {
    static var previews: some View {
        RateChip(rate: "12")
    }
}
