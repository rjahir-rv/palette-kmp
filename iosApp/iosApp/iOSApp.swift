import SwiftUI
import kmp

@main
struct PaletteApp: App {
    @UIApplicationDelegateAdaptor(appDelegate.self) var delegate
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

class appDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        KoinInitKt.doInitKoin()
        return true
    }
}
