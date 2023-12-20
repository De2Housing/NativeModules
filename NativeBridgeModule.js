import {NativeModules} from 'react-native';

/**
 * @typedef {{
 *  action: 'navigateToHomeSearch' |
 *   'navigateToEdgeTab' |
 *   'navigateBack' |
 *   'navigateToPOC' |
 *   'premiumPurchaseDenied' |
 *   'premiumPurchasedSuccessful' |
 *   'navigateToPremium' |
 *   'navigateToHomeLoans' |
 *   'navigateToPdp' |
 *   'navigateToFavoriteProperties' |
 *   'navigateToContactedProperties' |
 *   'navigateToHelpAndSupport' |
 *   'navigateToCalculator';
 *  params: Record<string, any>;
 * }} NavigationAction
 */

/**
 * @typedef {{
 *  isMediaPermissionGranted: (callback: Callback) => void;
 * }} NewBridgeModuleType
 * @returns {NewBridgeModuleType}
 */
function getNewBridge() {
  if (NativeModules.NativeBridgeModule != null) {
    return NativeModules.NativeBridgeModule;
  }
  console.error(
    'NativeBridgeModule not found. Please check native packages linking.',
  );
  return {
    isMediaPermissionGranted: () => null,
  };
}

const NativeBridgeModule = getNewBridge();

export default NativeBridgeModule;
