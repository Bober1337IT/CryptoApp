# CryptoApp

A modern Android application for tracking cryptocurrency data, built using the latest development standards, Clean Architecture, and Jetpack Compose.

## Overview

CryptoApp provides users with a comprehensive list of cryptocurrencies and detailed information about each coin, including market statistics, team information, and price trends. The project demonstrates the implementation of a scalable architecture and efficient data handling in a production-like environment.

## Features

- **Cryptocurrency List**: Browse a list of cryptocurrencies fetched from the CoinPaprika API.
- **Detailed Coin Information**:
    - Project description and activity status.
    - Tag-based categorization using FlowRow layouts.
    - Comprehensive price change analysis for multiple periods: 24h, 7d, 30d, and 1 year.
    - Listing of project team members.
- **Robust State Management**: Handling of Loading, Success, and Error states across the UI.
- **Data Transformation**: Implementation of DTO-to-Domain mapping and data aggregation (combining coin metadata with ticker price data).

## Technical Stack

- **Language**: Kotlin (2.0.21)
- **UI Framework**: Jetpack Compose with Material 3
- **Architecture**: Clean Architecture with MVVM (Model-View-ViewModel)
- **Dependency Injection**: Hilt (2.52)
- **Networking**: Retrofit 2.9.0 & GSON
- **Asynchronous Programming**: Kotlin Coroutines & Flow
- **Navigation**: Jetpack Compose Navigation
- **Build System**: Gradle with Version Catalog (libs.versions.toml)

## Architecture

The project follows Clean Architecture principles by separating the code into three distinct layers:

1. **Data Layer**: Contains API definitions (`CoinPaprikaApi`), DTO models, and the repository implementation (`CoinRepositoryImpl`). It handles data fetching and transformation.
2. **Domain Layer**: The core of the application. It contains the business models (`Coin`, `CoinDetail`), repository interfaces, and Use Cases (`GetCoinUseCase`, `GetCoinsUseCase`) that encapsulate specific business logic.
3. **Presentation Layer**: Responsible for the UI. It uses ViewModels to manage state and Compose screens (`CoinListScreen`, `CoinDetailScreen`) to render the data.

## API Integration

The application integrates with the CoinPaprika API. To provide a rich user experience, the `CoinRepositoryImpl` aggregates data from two separate endpoints:

- `GET /v1/coins`: To retrieve the general list of coins.
- `GET /v1/coins/{coinId}`: To retrieve specific metadata and team info.
- `GET /v1/tickers/{coinId}`: To retrieve real-time price changes and market values.

## Project Structure

```text
com.bober.cryptoapp
├── common                # Constants, Resource wrapper, and Utility functions
├── data
│   ├── remote            # API interface and DTOs
│   └── repository        # Repository implementation
├── di                    # Hilt modules
├── domain
│   ├── model             # Domain models
│   ├── repository        # Repository interfaces
│   └── use_case          # Business logic cases
└── presentation
    ├── coin_detail       # ViewModels, States, and Detail Screen components
    ├── coin_list         # ViewModels, States, and List Screen components
    └── ui.theme          # Material3 theme definitions
```
