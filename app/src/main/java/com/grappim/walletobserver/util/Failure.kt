package com.grappim.walletobserver.util

/**
 * Base Class for handling errors/failures/exceptions.
 * Every feature specific onFailure should extend [FeatureFailure] class.
 */
sealed class Failure {
  object NetworkConnection : Failure()
  object ServerError : Failure()

  /** * Extend this class for feature specific failures.*/
  abstract class FeatureFailure : Failure()
}
