var exec = require('cordova/exec');

var AndroidPrivacyScreen = function(){};  

AndroidPrivacyScreen.prototype.removePrivacyScreen = function(arg0, success, error) {
    exec(success, error, "PrivacyScreen", "removePrivacyScreen", arg0);
    console.warn('<--- removeAndroidPrivacyScreen --->')
};

AndroidPrivacyScreen.prototype.addPrivacyScreen = function(arg0, success, error) {
    exec(success, error, "PrivacyScreen", "addPrivacyScreen", arg0);
    console.warn('<--- addAndroidPrivacyScreen --->')
};

var androidPrivacyScreen = new AndroidPrivacyScreen();
module.exports = androidPrivacyScreen; 