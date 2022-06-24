import SwiftUI
import shared

struct MainScreen: View {
    @State private var selectedTab: Int = 0
    
    let tabs: [Tab] = [
        .init(title: "Playing"),
        .init(title: "Upcoming")
    ]
    
    init() {
        UINavigationBar.appearance().backgroundColor = UIColor(Color.black)
        UINavigationBar.appearance().titleTextAttributes = [.foregroundColor: UIColor.white]
        UINavigationBar.appearance().isTranslucent = false
    }
    
    var body: some View {
        NavigationView{
            GeometryReader { geo in
                VStack(spacing: 0) {
                    TabBarButton(tabs: tabs, geoWidth: geo.size.width, selectedTab: $selectedTab)
                    
                    // Views
                    TabView(selection: $selectedTab,
                            content: {
                        NowPlayingMoviesScreen()
                            .tag(0)
                        UpcomingMoviesScreen()
                            .tag(1)
                    }).tabViewStyle(PageTabViewStyle(indexDisplayMode: .never))
                }
            }
            .navigationBarTitleDisplayMode(.inline)
            .navigationBarTitle("The Movies")
        }.accentColor(.yellow)
    }
}

struct MainScreen_Previews: PreviewProvider {
    static var previews: some View {
        MainScreen()
    }
}
