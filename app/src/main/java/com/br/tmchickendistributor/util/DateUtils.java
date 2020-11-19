package com.br.tmchickendistributor.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  private static final SimpleDateFormat DD_MM_YYYY_HH_MM = new SimpleDateFormat("dd/MM/yyyy hh:mm");

  private static final SimpleDateFormat DD_MM_YYYY = new SimpleDateFormat("dd/MM/yyyy");

  private static final SimpleDateFormat YYYY_MM_DD_HH_MM_SS =
      new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

  public static String formatarDateddMMyyyyParaString(java.util.Date dateToFormat) {

    return DD_MM_YYYY.format(dateToFormat);
  }

  public static java.util.Date formatarDateParaddMMyyyyhhmm(java.util.Date dateToFormat)
      throws ParseException {

    String strDate = DD_MM_YYYY_HH_MM.format(dateToFormat);

    return DD_MM_YYYY_HH_MM.parse(strDate);
  }

  public static String converterDateParaStringYYYYMMDDHHMM(java.util.Date dateToFormat)
      throws ParseException {

    String dataFormatada = DD_MM_YYYY_HH_MM.format(dateToFormat);
    return dataFormatada;
  }

  public static String formatarParaYYYYMMDDHHMMSS(java.util.Date dateToFormat) {

    return YYYY_MM_DD_HH_MM_SS.format(dateToFormat);
  }

  public static String formatarDateddMMyyyyhhmmParaString(java.util.Date dateToFormat) {

    return DD_MM_YYYY_HH_MM.format(dateToFormat);
  }

  public static String retirarBarrasDaDataNoPadraoddMMyyyyParaString(java.util.Date dateToFormat) {

    return DD_MM_YYYY.format(dateToFormat).replace("/", "");
  }

  public static Date converterStringParaDate(String dataSTR) throws ParseException {

    return DD_MM_YYYY.parse(dataSTR);
  }

  public static boolean ehUmPeriodoValido(Date dataInicial, Date dataFinal) {
    return dataInicial.before(dataFinal) || dataInicial.equals(dataFinal);
  }
}
