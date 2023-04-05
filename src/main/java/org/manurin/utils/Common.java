package org.manurin.utils;

import org.apache.commons.lang3.StringUtils;
import org.manurin.repository.model.TariffEntity;

public final class Common {
    private Common() {
    }

    public static boolean isaBoolean(String name, Boolean unlimInternet, Boolean unlimCalls, Boolean archived, TariffEntity tariff) {
        return nameChecker(name, tariff.getName()) &&
                archivedChecker(archived, tariff.isArchived()) &&
                internetChecker(unlimInternet, tariff.getBundledProductId().getInternet()) &&
                callsChecker(unlimCalls, tariff.getBundledProductId().getCalls());

    }

    private static boolean callsChecker(Boolean unlimCalls1, Integer unlimCalls2) {
        if (unlimCalls1 == null) {
            return true;
        } else {
            return( unlimCalls2 < 0 ) == unlimCalls1;
        }
    }

    private static boolean internetChecker(Boolean unlimInternet1, Integer unlimInternet2) {
        if (unlimInternet1 == null) {
            return true;
        } else {
            return (unlimInternet2 < 0) == unlimInternet1;
        }
    }

    private static boolean archivedChecker(Boolean archived1, Boolean archived2) {
        if (archived1 == null) {
            return true;
        } else {
            return archived1.equals(archived2);
        }
    }

    private static boolean nameChecker(String name1, String name2) {
        if (name1 == null) {
            return true;
        } else {
            return StringUtils.getLevenshteinDistance(name1.toUpperCase(), name2.toUpperCase()) <= 2;
        }
    }
}
