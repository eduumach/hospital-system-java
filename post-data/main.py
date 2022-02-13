import json
import requests
import pandas as pd
from pathlib import Path

address = "http://localhost:8080"


def postHeartRate(directory_name):
    url = address + '/heart-rate/'
    heartRate = []

    open_files = Path(directory_name).glob('*')
    for file in open_files:
        dataframe = pd.read_fwf(file, sep="\t")

        dataframe = dataframe.rename(columns={"CPF": "cpf", "EPOC": "epoch", "ind_card": "heartRate"})
        dataframe = dataframe.astype({"cpf": "string", "epoch": "int64", "heartRate": "float"})
        dataframeDict = dataframe.to_dict("records")
        heartRate = heartRate.copy() + dataframeDict.copy()

    for i in heartRate:
        r = requests.post(url, json=i)
        print(r.text)


def postPulmonaryIndex(directory_name):
    url = address + '/pulmonary-index/'
    pulmonaryIndex = []

    open_files = Path(directory_name).glob('*')
    for file in open_files:
        dataframe = pd.read_fwf(file, sep="\t")

        dataframe = dataframe.rename(columns={"CPF": "cpf", "EPOC": "epoch", "ind_pulm": "pulmonaryIndex"})
        dataframe = dataframe.astype({"cpf": "string", "epoch": "int64", "pulmonaryIndex": "float"})
        dataframeDict = dataframe.to_dict("records")
        pulmonaryIndex = pulmonaryIndex.copy() + dataframeDict.copy()

    for i in pulmonaryIndex:
        r = requests.post(url, json=i)
        print(r.text)


def postPatients(file):
    url = address + '/patients/'

    open_file = open(file, 'r')
    data = json.load(open_file)

    for i in data:
        r = requests.post(url, json={"name": i['nome'], "age": int(i['idade']), "cpf": i['cpf'], "rg": i['rg'],
                                     "dateOfBirth": i['data_nasc'], "sex": i['sexo'], "sign": i['signo'],
                                     "mother": i['mae'], "father": i['pai'], "email": i['email'],
                                     "password": i['senha'],
                                     "zipCode": i['cep'], "address": i['endereco'], "number": int(i['numero']),
                                     "neighborhood": i['bairro'], "city": i['cidade'], "state": i['estado'],
                                     "landline": i['telefone_fixo'], "phoneNumber": i['celular'], "height": i['altura'],
                                     "weight": int(i['peso']), "bloodType": i['tipo_sanguineo'], "color": i['cor']})
        print(r.text)


postPatients('dados/pacientes.json')
postHeartRate('dados/indice_cardiaco')
postPulmonaryIndex('dados/indice_pulmonar')
