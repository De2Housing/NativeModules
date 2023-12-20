import React, {useState} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  useColorScheme,
  Pressable,
  Text,
} from 'react-native';

import {Colors, Header} from 'react-native/Libraries/NewAppScreen';
import NativeBridgeModule from './NativeBridgeModule';

const App = () => {
  const isDarkMode = useColorScheme() === 'dark';
  const [text, setText] = useState('Permission');

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  const permissionModule = () => {
    NativeBridgeModule.isMediaPermissionGranted(() => {
      setText('Permission Granted');
    });
  };

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />
      <ScrollView
        contentInsetAdjustmentBehavior="automatic"
        style={backgroundStyle}>
        <Header />
        <Text>{text}</Text>
        <Pressable onPress={permissionModule}>
          <Text>{'Button'}</Text>
        </Pressable>
      </ScrollView>
    </SafeAreaView>
  );
};

export default App;
