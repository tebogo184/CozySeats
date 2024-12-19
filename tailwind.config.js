/** @type {import('tailwindcss').Config} */
export const content = ["./src/main/resources/static/**/*.{html,js}"];
export const theme = {
  extend: {
    // Display Utilities
    display: ['table', 'table-row', 'table-cell', 'table-caption', 'inline-table', 'table-column', 'table-column-group'],

    // Flexbox & Grid Utilities
    flex: {
      '1': '1 1 0%',
      'auto': '1 1 auto',
      'initial': '0 1 auto',
      'none': 'none',
    },
    gridTemplateColumns: {
      '12': 'repeat(12, minmax(0, 1fr))',
      'none': 'none',
    },
    gridTemplateRows: {
      'none': 'none',
    },

    // Spacing (Padding & Margin)
    spacing: {
      'px': '1px',
      '0.5': '0.125rem',
      '1': '0.25rem',
      '1.5': '0.375rem',
      '2': '0.5rem',
      '2.5': '0.625rem',
      '3': '0.75rem',
      '3.5': '0.875rem',
      '4': '1rem',
    },

    // Borders
    borderRadius: {
      'none': '0px',
      'sm': '0.125rem',
      'default': '0.25rem',
      'md': '0.375rem',
      'lg': '0.5rem',
      'full': '9999px',
    },

    // Shadows
    boxShadow: {
      'sm': '0 1px 2px 0 rgba(0, 0, 0, 0.05)',
      'default': '0 1px 3px 0 rgba(0, 0, 0, 0.1), 0 1px 2px 0 rgba(0, 0, 0, 0.06)',
      'md': '0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06)',
      'lg': '0 10px 15px -3px rgba(0, 0, 0, 0.1), 0 4px 6px -2px rgba(0, 0, 0, 0.05)',
      'xl': '0 20px 25px -5px rgba(0, 0, 0, 0.1), 0 10px 10px -5px rgba(0, 0, 0, 0.04)',
      '2xl': '0 25px 50px -12px rgba(0, 0, 0, 0.25)',
      'inner': 'inset 0 2px 4px 0 rgba(0, 0, 0, 0.06)',
      'none': 'none',
    },

    // Opacity
    opacity: {
      '0': '0',
      '5': '0.05',
      '10': '0.1',
      '20': '0.2',
      '25': '0.25',
      '50': '0.5',
      '75': '0.75',
      '100': '1',
    },

    // Colors
    colors: {
      transparent: 'transparent',
      current: 'currentColor',
      black: '#000',
      white: '#fff',
      gray: {
        100: '#f7fafc',
        200: '#edf2f7',
        300: '#e2e8f0',
        400: '#cbd5e0',
        500: '#a0aec0',
        600: '#718096',
        700: '#4a5568',
        800: '#2d3748',
        900: '#1a202c',
      },
      red: {
        100: '#fff5f5',
        200: '#fed7d7',
        500: '#f56565',
        900: '#742a2a',
      },
    },

    // Z-Index
    zIndex: {
      '0': 0,
      '10': 10,
      '20': 20,
      '30': 30,
      '40': 40,
      '50': 50,
      'auto': 'auto',
    },

    // Font Sizes
    fontSize: {
      'xs': '0.75rem',
      'sm': '0.875rem',
      'base': '1rem',
      'lg': '1.125rem',
      'xl': '1.25rem',
      '2xl': '1.5rem',
      '3xl': '1.875rem',
      '4xl': '2.25rem',
      '5xl': '3rem',
      '6xl': '3.75rem',
      '7xl': '4.5rem',
    },
  },
};
export const plugins = [];
export const corePlugins = {
  preflight: true,
  container: true,
  space: true,
  divideWidth: true,
  divideColor: true,
  typography: true,
  visibility: true,
  accessibility: true,
  alignItems: true,
  justifyContent: true,
  flexGrow: true,
  gridColumn: true,
  gridRow: true,
  animation: true,
  transform: true,
};
