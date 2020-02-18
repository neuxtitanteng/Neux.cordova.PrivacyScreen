/********* Neux.cordova.PrivacyScreen.m Cordova Plugin Implementation *******/

#import "PrivacyScreen.h"

static UIImageView *imageView;
static UIVisualEffectView *effectView;

@implementation PrivacyScreen

- (void)pluginInitialize
{
  [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(onAppDidBecomeActive:)
                                               name:UIApplicationDidBecomeActiveNotification object:nil];

  [[NSNotificationCenter defaultCenter] addObserver:self selector:@selector(onAppWillResignActive:)
                                               name:UIApplicationWillResignActiveNotification object:nil];
}

- (void)onAppDidBecomeActive:(UIApplication *)application
{
    [effectView removeFromSuperview];
}

- (void)onAppWillResignActive:(UIApplication *)application
{
    effectView = [[UIVisualEffectView alloc] initWithEffect: [UIBlurEffect effectWithStyle: UIBlurEffectStyleExtraLight]];
    effectView.frame = CGRectMake(0, 0, [[UIScreen mainScreen] bounds].size.width, [[UIScreen mainScreen] bounds].size.height);
    [self.viewController.view bringSubviewToFront:effectView];
    [self.viewController.view addSubview:effectView];
}

- (BOOL) isUsingCDVLaunchScreen {
    NSString* launchStoryboardName = [[NSBundle mainBundle] objectForInfoDictionaryKey:@"UILaunchStoryboardName"];
    if (launchStoryboardName) {
        return ([launchStoryboardName isEqualToString:@"CDVLaunchScreen"]);
    } else {
        return NO;
    }
}

@end