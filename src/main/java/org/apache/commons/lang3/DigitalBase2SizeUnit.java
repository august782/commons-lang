/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.lang3;

/**
 * A {@code DigitalBase2SizeUnit} represents digital size at a given unit of granularity and provides utility methods to
 * convert across units, and to perform sizing operations in these units. A {@code DigitalBase2SizeUnit} does not
 * maintain size information, but only helps organize and use size representations that may be maintained separately
 * across various contexts.
 * <p>
 * A bit is defined as one eighth (8) of a byte, a byte as one thousand twenty fourth (1024) of a kilobyte, a kilobyte
 * as as one thousand twenty fourth (1024) of a megabyte, a megabyte as one thousand twenty fourth (1024) of a terabyte.
 * </p>
 *
 * @since 3.5
 * @see <a href="https://en.wikipedia.org/wiki/Binary_prefix">Binary prefix</a>
 * @see DigitalBase10SizeUnit
 */
public enum DigitalBase2SizeUnit {

    /**
     * Bits.
     */
    BITS("b", "bit") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toBytes(s);
        }

        @Override
        public long toBits(final long size) {
            return size;
        }

        @Override
        public long toBytes(final long size) {
            return size / K1;
        }

        @Override
        public long toGigabytes(final long size) {
            return size / K4;
        }

        @Override
        public long toKilobytes(final long size) {
            return size / K2;
        }

        @Override
        public long toMegabytes(final long size) {
            return size / K3;
        }

        @Override
        public long toTerabytes(final long size) {
            return size / K5;
        }
    },

    /**
     * Bytes.
     */
    BYTES("B", "byte") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toBytes(s);
        }

        @Override
        public long toBits(long size) {
            return x(size, MULB, Long.MAX_VALUE / (K1 / K0));
        }

        @Override
        public long toBytes(final long size) {
            return size;
        }

        @Override
        public long toGigabytes(final long size) {
            return size / K3;
        }

        @Override
        public long toKilobytes(final long size) {
            return size / K1;
        }

        @Override
        public long toMegabytes(final long size) {
            return size / K2;
        }

        @Override
        public long toTerabytes(final long size) {
            return size / K4;
        }
    },

    /**
     * Gigbytes (Gigabytes).
     */
    GIGABYTES("Gi", "gibibyte", "gigabyte", "G") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toGigabytes(s);
        }

        @Override
        public long toBits(long size) {
            return x(size, K3, Long.MAX_VALUE / K2);
        }

        @Override
        public long toBytes(final long size) {
            return x(size, K3, Long.MAX_VALUE / K3);
        }

        @Override
        public long toGigabytes(final long size) {
            return size;
        }

        @Override
        public long toKilobytes(final long size) {
            return x(size, K3 / K1, Long.MAX_VALUE / (K3 / K1));
        }

        @Override
        public long toMegabytes(final long size) {
            return x(size, K3 / K2, Long.MAX_VALUE / (K3 / K2));
        }

        @Override
        public long toTerabytes(final long size) {
            return size / (K4 / K3);
        }
    },

    /**
     * Kibibytes (Kilobytes)
     */
    KILOBYTES("Ki", "kibibyte", "kilobytes", "K") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toKilobytes(s);
        }

        @Override
        public long toBits(long size) {
            return x(size, K1, Long.MAX_VALUE / K1);
        }

        @Override
        public long toBytes(final long size) {
            return x(size, K1, Long.MAX_VALUE / K1);
        }

        @Override
        public long toGigabytes(final long size) {
            return size / (K3 / K1);
        }

        @Override
        public long toKilobytes(final long size) {
            return size;
        }

        @Override
        public long toMegabytes(final long size) {
            return size / (K2 / K1);
        }

        @Override
        public long toTerabytes(final long size) {
            return size / (K4 / K1);
        }
    },

    /**
     * Mebibytes (Megabytes)
     */
    MEGABYTES("Mi", "mebibyte", "megabytes", "M") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toMegabytes(s);
        }

        @Override
        public long toBits(long size) {
            return x(size, K2, Long.MAX_VALUE / K1);
        }

        @Override
        public long toBytes(final long size) {
            return x(size, K2, Long.MAX_VALUE / K2);
        }

        @Override
        public long toGigabytes(final long size) {
            return size / (K3 / K2);
        }

        @Override
        public long toKilobytes(final long size) {
            return x(size, K2 / K1, Long.MAX_VALUE / (K2 / K1));
        }

        @Override
        public long toMegabytes(final long size) {
            return size;
        }

        @Override
        public long toTerabytes(final long size) {
            return size / (K4 / K2);
        }
    },

    /**
     * Tebibytes (Terabytes)
     */
    TERABYTES("Ti", "tebibyte", "terabyte", "T") {
        @Override
        public long convert(final long s, final DigitalBase2SizeUnit u) {
            return u.toTerabytes(s);
        }

        @Override
        public long toBits(long size) {
            return x(size, K4, Long.MAX_VALUE / K3);
        }

        @Override
        public long toBytes(final long size) {
            return x(size, K4, Long.MAX_VALUE / K4);
        }

        @Override
        public long toGigabytes(final long size) {
            return x(size, K4 / K3, Long.MAX_VALUE / (K4 / K3));
        }

        @Override
        public long toKilobytes(final long size) {
            return x(size, K4 / K1, Long.MAX_VALUE / (K4 / K1));
        }

        @Override
        public long toMegabytes(final long size) {
            return x(size, K4 / K2, Long.MAX_VALUE / (K4 / K2));
        }

        @Override
        public long toTerabytes(final long size) {
            return size;
        }
    };

    private static final long MULB = 8L;
    private static final long MULK = 1024L;
    private static final long K0 = 1L;
    private static final long K1 = K0 * MULK;
    private static final long K2 = K1 * MULK;
    private static final long K3 = K2 * MULK;
    private static final long K4 = K3 * MULK;
    private static final long K5 = K4 * MULK;

    private static long x(final long d, final long m, final long over) {
        if (d > over) {
            return Long.MAX_VALUE;
        }
        if (d < -over) {
            return Long.MIN_VALUE;
        }
        return d * m;
    }

    private final String name;
    private final String symbol;
    private final String customarySymbol;
    private final String customaryName;

    /**
     * Creates a new enum with IEC symbol and name
     * 
     * @param iecSymbol
     *            IEC symbol
     * @param iecName
     *            IEC name
     * @see <a href="https://en.wikipedia.org/wiki/IEC_80000-13">IEC 80000-13</a>
     */
    private DigitalBase2SizeUnit(String iecSymbol, String iecName) {
        this.name = iecName;
        this.symbol = iecName;
        this.customarySymbol = iecSymbol;
        this.customaryName = iecName;
    }

    /**
     * Creates a new enum with IEC symbol and name
     * 
     * @param iecSymbol
     *            IEC symbol
     * @param iecName
     *            IEC name
     * @param customarySymbol
     *            customary symbol
     * @param customaryName
     *            customary name
     * @see <a href="https://en.wikipedia.org/wiki/IEC_80000-13">IEC 80000-13</a>
     */
    private DigitalBase2SizeUnit(String iecSymbol, String iecName, String customarySymbol, String customaryName) {
        this.name = iecName;
        this.symbol = iecName;
        this.customarySymbol = customarySymbol;
        this.customaryName = customaryName;
    }

    protected abstract long convert(final long sourceSize, final DigitalBase2SizeUnit sourceUnit);

    /**
     * Gets the customary name.
     * 
     * @return the customary name.
     */
    public String getCustomaryName() {
        return customaryName;
    }

    /**
     * Gets the customary symbol.
     * 
     * @return the customary symbol.
     */
    public String getCustomarySymbol() {
        return customarySymbol;
    }

    /**
     * Gets the name.
     * 
     * @return the name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the symbol.
     * 
     * @return the symbol.
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Equivalent to {@code BITS.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toBits(final long size);

    /**
     * Equivalent to {@code BYTES.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toBytes(final long size);

    /**
     * Equivalent to {@code GIGABYTES.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toGigabytes(final long size);

    /**
     * Equivalent to {@code KILOBYTES.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toKilobytes(final long size);

    /**
     * Equivalent to {@code MEGABYTES.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toMegabytes(final long size);

    /**
     * Equivalent to {@code TERABYTES.convert(size, this)}.
     * 
     * @param size
     *            the size
     * @return the converted size
     * @see #convert
     */
    public abstract long toTerabytes(final long size);

}